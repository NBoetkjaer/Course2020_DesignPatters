#pragma once
#include "Player.h"
#include <string>

class IColorSelector
{
public:
    virtual Color SelectColor() = 0;
};

class Link
{
public:
    int m_start;
    int m_end;
};

class IBoard
{
public:
    virtual int StartPostion() const = 0;
    virtual int EndPostion() const = 0;
    virtual int NewPosition(int oldPos, int diceValue) const = 0;
    virtual int EvaluatePosition(int pos) const = 0;
};

class IDice
{
public:
    virtual int Roll() const = 0;
};

class IGameOutputter
{
public:
    virtual void DisplayWinner(const Player& player) const = 0;
    virtual void DisplayPlayerPosition(const Player& player) const = 0;
    virtual void DisplayPlayerThreats(const Player& player, const IBoard* board) const = 0;
};
