#include "stdafx.h"
#include "ColorSelector.h"

#include <iostream>
#include <string>
#include <sstream>
#include <algorithm>

ColorSelector::ColorSelector()
{
    // Initialize collection to all available colors.
    m_availableColors = { Color::red, Color::blue, Color::green, Color::yellow};
}

ColorSelector::~ColorSelector()
{
}

Color ColorSelector::SelectColor()
{
    ShowAvailableColors();

    Color color;
    if (m_availableColors.size() == 1)
    {   // Special case when only one color is left to choose from.
        color = m_availableColors[0];
    }
    else
    {
        // Let player select a color.
        while (true)
        {
            std::cout << "Please select your color: ";
            int iColor = -1;
            std::string userInput;
            std::getline(std::cin, userInput);
            std::stringstream(userInput) >> iColor;

            auto itColor = std::find(m_availableColors.begin(), m_availableColors.end(), static_cast<Color>(iColor));
            if (itColor != m_availableColors.end())
            {
                color = *itColor;
                break;
            }
            else
            {
                std::cout << std::endl << "Invalid color" << std::endl;
                ShowAvailableColors();
            }
        }
    }

    // Remove the color from the list of valid colors.
    m_availableColors.erase(std::remove(m_availableColors.begin(), m_availableColors.end(), color), m_availableColors.end());
    return color;
}

void ColorSelector::ShowAvailableColors() const
{
    // Print available colors to choose from.
    std::cout << std::endl << "Available colors: ";
    for (auto clr : m_availableColors)
    {
        std::cout << GetColorName(clr) << " = " << static_cast<int>(clr) << " ";
    }
    std::cout << std::endl;
}