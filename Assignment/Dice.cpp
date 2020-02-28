#include "stdafx.h"
#include "Dice.h"

Dice::Dice()
{
    // Taken from: https://en.cppreference.com/w/cpp/numeric/random/uniform_int_distribution
    std::random_device rd;  //Will be used to obtain a seed for the random number engine
    m_randomGenerator.seed(rd());
    m_randomDistribution = std::uniform_int_distribution<int>(1, 6);
}

int Dice::Roll() const
{
    return m_randomDistribution(m_randomGenerator);
}