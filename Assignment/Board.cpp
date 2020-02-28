#include "stdafx.h"
#include "Board.h"

#include <algorithm>


Board::Board(int size)
{
    m_size = size;
    // Create snakes and ladders on board
    m_links.clear();
    CreateLinks(m_NUM_SNAKES, LinkType_Snake);
    CreateLinks(m_NUM_LADDERS, LinkType_Ladder);
}

Board::~Board()
{
}

int Board::NewPosition(int oldPos, int diceValue) const
{
    int newPos = oldPos + diceValue;
    if (newPos > EndPostion())
    {
        newPos -= newPos - EndPostion();
    }
    return newPos;
}

int Board::EvaluatePosition(int pos) const
{
    const auto itLink = std::find_if(m_links.cbegin(), m_links.cend(),
        [pos](const Link& lnk) { return pos == lnk.m_start; });
    if (itLink != m_links.cend())
    {
        return itLink->m_end;
    }
    return pos;
}

void Board::CreateLinks(int linkCount, LinkType linkType)
{
    for (int i = 0; i < linkCount; i++)
    {
        // Create one big link, the rest are small.
        const int MinMove = (i == 0) ? m_LARGE_LINK_MIN_MOVE : m_SMALL_LINK_MIN_MOVE;
        const int MaxVariation = (i == 0) ? m_size : m_SMALL_LINK_MAX_VARIATION;

        // Keep creating random links until success.
        for (;;)
        {
            Link link;

            link.m_start = rand() % m_size;
            if (linkType == LinkType_Snake)
            {
                link.m_end = link.m_start - (MinMove + (rand() % MaxVariation));
            }
            else // not a snake, assume ladder
            {
                link.m_end = link.m_start + (MinMove + (rand() % MaxVariation));
            }
            if (link.m_start >= m_size || link.m_end < 0)
                continue; // link is outside board limits, try again

                          // Check for collision with existing links.
            size_t j;
            for (j = 0; j < m_links.size(); j++)
            {
                if (m_links[j].m_start == link.m_start
                    || m_links[j].m_start == link.m_end
                    || m_links[j].m_end == link.m_start
                    || m_links[j].m_end == link.m_end)
                    break; // collision
            }
            if (j < m_links.size())
                continue; // collision, try again

            m_links.push_back(link);
            break; // success, exit to outer loop
        }
    }
}
