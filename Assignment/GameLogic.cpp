#include "stdafx.h"
#include "GameLogic.h"

#include"Interfaces.h"

#include <iostream>
#include <string>
#include <sstream>

GameLogic::GameLogic()
{
}

GameLogic::~GameLogic()
{
}
void GameLogic::NewGame(IBoard *board, IDice *dice, IGameOutputter *gameOutput)
{
    m_board = board;
    m_dice = dice;
    m_gameView = gameOutput;

    m_currentPlayerIdx = 0;
    for (auto &player : m_players)
    {
        player.SetPosition(m_board->StartPostion());
    }
}

void GameLogic::AddPlayer(const Player &player)
{
    m_players.push_back(player);
}

void GameLogic::TakeTurn()
{
    std::cout << std::endl;
    // Select the active player.
    Player& curPlayer = m_players[m_currentPlayerIdx];
    m_gameView->DisplayPlayerPosition(curPlayer);
    m_gameView->DisplayPlayerThreats(curPlayer, m_board);

    std::cout << "Press Enter to roll your dice" << std::endl;
    std::string userInput;
    std::getline(std::cin, userInput);
    // Roll the dice.
    int diceValue = m_dice->Roll();

    std::cout << "You dice show " << diceValue << std::endl;
    // Calculate new player postion (local variable) 
    int newPos = m_board->NewPosition(curPlayer.GetPostion(), diceValue);
    // Ask board for colliding link.
    int AdjustedPos = m_board->EvaluatePosition(newPos);
    if (AdjustedPos > newPos)
    {
        // Ladder
        std::cout << " Your hit a ladder" << std::endl;
    }
    else if (AdjustedPos < newPos)
    {
        // Snake
        std::cout << " Your hit a snake" << std::endl;
    }
    //  - inform player and adjust new position.
    // Set Player position
    curPlayer.SetPosition(AdjustedPos);
    // Inform player of new position.
    m_gameView->DisplayPlayerPosition(curPlayer);

}

bool GameLogic::Finished() const
{
    for (const auto& player : m_players)
    {
        if (player.GetPostion() == m_board->EndPostion())
        {
            return true;
        }
    }
    return false;
}

void GameLogic::RunGameLoop()
{
    while (true)
    {
        TakeTurn();
        if (Finished())
        {
            auto winner = GetCurrentPlayer();
            // Output 
            m_gameView->DisplayWinner(winner);
            break;
        }
        else
        {
            SelectNextPlayer();
        }
        
    }
}
