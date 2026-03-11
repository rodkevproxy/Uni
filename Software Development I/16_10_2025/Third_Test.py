import random

hidden = 6

guess = int(input("Guess a number between 1 and 20: "))

while guess != hidden:
    if guess < hidden:
        print("Too low! Try again.")
    else:
        print("Too high! Try again.")
        
    guess = int(input("Guess a number between 1 and 20: "))

print(f"Congratulations! You guessed it correctly. The number was {hidden}.")

