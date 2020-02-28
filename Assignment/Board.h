#pragma once
#include "Interfaces.h"

#include <vector>

class Board: public IBoard
{
public:
    Board(int size);
    ~Board();
    int StartPostion() const  override { return 0; }
    int EndPostion() const  override { return m_size-1; }
    int NewPosition(int oldPos, int diceValue) const override;
    int EvaluatePosition(int pos) const override;

private:
    const int m_NUM_SNAKES = 4;
    const int m_NUM_LADDERS = 4;

    const int m_SMALL_LINK_MIN_MOVE = 5;
    const int m_LARGE_LINK_MIN_MOVE = 20;
    const int m_SMALL_LINK_MAX_VARIATION = 10;
    enum LinkType { LinkType_Snake, LinkType_Ladder };

    void CreateLinks(int linkCount, LinkType linkType);

    int m_size = 100;
    std::vector<Link> m_links;
};
