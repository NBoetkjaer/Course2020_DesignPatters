#pragma once
#include <string>

enum class Color { red, blue, green, yellow };

std::string GetColorName(Color);

class Player
{
public:
    Player(Color color) { m_color = color; }              // Construct a new player with the given color.
    void SetPosition(int newPos) { m_position = newPos; } // Set the postion of the player.
    int GetPostion() const { return m_position; }         // Get the current position of the player.
    Color GetColor() const  { return m_color; }
private:

    int m_position; // The player position on the board.
    Color m_color;  // The color of the player.
};