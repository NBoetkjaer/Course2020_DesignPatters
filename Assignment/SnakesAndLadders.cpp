// SnakesAndLadders.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "GameLogic.h"
#include "Board.h"
#include "Dice.h"
#include "Player.h"
#include "ColorSelector.h"
#include "GameOutputter.h"

#include <memory>
#include <conio.h>
#include <iostream>
#include <string>
#include <sstream>
#include <algorithm>

int main()
{
    bool playAgain = true;
    while (playAgain)
    {
        auto playerColors = std::make_unique<ColorSelector>();
        // Create the board, dice and game view.
        Board board = Board(100);
        Dice dice = Dice();
        GameOutputter gameOutput = GameOutputter();

        // Query number of players.
        int numPlayers = -1;
        std::string userInput;
        while (numPlayers < 1 || numPlayers > 4)
        {
            std::cout << "How many players want to play (1-4)?";
            std::getline(std::cin, userInput);
            std::stringstream(userInput) >> numPlayers;
        }

        // Create the game logic object and add players, each with its own color.
        GameLogic game = GameLogic();

        for (int iPlayer = 0; iPlayer < numPlayers; iPlayer++)
        {
            std::cout << std::endl << "Player " << std::to_string(iPlayer) << std::endl;
            Color color = playerColors->SelectColor();
            game.AddPlayer(Player(color));
            std::cout << "Player " << std::to_string(iPlayer) << " selected the " << GetColorName(color) << " color" << std::endl;
        }

        // Start and run a new game.
        game.NewGame(&board, &dice, &gameOutput);
        game.RunGameLoop();

        std::cout << "Do you want to play another game? [y/n]";

        std::getline(std::cin, userInput);
        playAgain = userInput.size() > 0 && userInput[0] == 'y';
    }
    return 0;
}

