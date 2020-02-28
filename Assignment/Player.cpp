#include "stdafx.h"
#include "Player.h"

std::string GetColorName(Color color)
{
    switch (color)
    {
    case Color::red: return "red";
    case Color::blue: return "blue";
    case Color::green: return "green";
    case Color::yellow: return "yellow";
    default:  return "unknown color";
    }
}