#pragma once
#include <vector>
#include "Player.h"

// Forward declare the interfaces
class IDice;
class IBoard;
class IGameOutputter;

class GameLogic
{
public:
    GameLogic();
    ~GameLogic();
    void NewGame(IBoard *board, IDice *dice, IGameOutputter *gameOutput);
    void AddPlayer(const Player &player);
    const Player & GetCurrentPlayer() const { return m_players[m_currentPlayerIdx]; }
    void RunGameLoop();
private:
    void TakeTurn();
    void SelectNextPlayer() {m_currentPlayerIdx = (++m_currentPlayerIdx) % m_players.size();}
    bool Finished() const;
    IBoard *m_board = nullptr;
    IDice  *m_dice = nullptr;
    IGameOutputter  *m_gameView = nullptr;

    std::vector<Player> m_players;  // Collection of players.
    int m_currentPlayerIdx;         // Index of current player in m_players vector.
};

