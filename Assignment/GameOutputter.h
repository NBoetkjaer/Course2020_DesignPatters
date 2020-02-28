#pragma once
#include "Interfaces.h"

class GameOutputter : public IGameOutputter
{
public:
    void DisplayWinner(const Player& player) const override;
    void DisplayPlayerPosition(const Player& player) const override;
    void DisplayPlayerThreats(const Player& player, const IBoard* board) const override;
};