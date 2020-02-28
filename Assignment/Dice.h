#pragma once
#include "Interfaces.h"

#include <random>

class DiceSimple : public IDice
{
public:
    DiceSimple(int numFaces = 6) : m_numFaces(numFaces) {}
    int Roll() const override { return (rand() % 6) + 1; }
private:
    int m_numFaces;
};


class Dice : public IDice
{
public:
    Dice();
    int Roll() const override;
private:
    mutable std::mt19937 m_randomGenerator;
    std::uniform_int_distribution<int> m_randomDistribution;
};