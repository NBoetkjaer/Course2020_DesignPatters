#include "stdafx.h"
#include "GameOutputter.h"

#include <iostream>
#include <string>
#include <sstream>

void GameOutputter::DisplayWinner(const Player& player) const
{
    std::cout << "Player " << GetColorName(player.GetColor()) << " is the winner " << std::endl;
}

void GameOutputter::DisplayPlayerPosition(const Player& player) const
{
    std::cout << "Player " << GetColorName(player.GetColor()) << " position is " << player.GetPostion() << std::endl;
}

void GameOutputter::DisplayPlayerThreats(const Player& player, const IBoard* board) const
{
    auto pos = player.GetPostion() + 1;
    for (int i = 1; i < 7; i++, pos++)
    {
        if(pos > board->EvaluatePosition(pos))
        { 
            std::cout << "snake if you roll a " << i << std::endl;
        }
        else if (pos < board->EvaluatePosition(pos))
        {
            std::cout << "ladder if you roll a " << i << std::endl;
        }
        else
        {
            //std::cout << "no threat if you roll a " << i << std::endl;
        }
    }
}