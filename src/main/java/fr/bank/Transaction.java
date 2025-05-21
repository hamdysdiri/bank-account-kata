package fr.bank;

import java.time.LocalDate;

public record Transaction(LocalDate date, int amount) {}

