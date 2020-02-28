#pragma once
#include "Interfaces.h"
#include <vector>

class ColorSelector : public IColorSelector
{
public:
    ColorSelector();
    ~ColorSelector();

    Color SelectColor() override;
private:
    void ShowAvailableColors() const;
    std::vector<Color> m_availableColors;
};

