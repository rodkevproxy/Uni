choice = int(input("Enter 1 to convert from Celsius to Fahrenheit or 2 to convert from Fahrenheit to Celsius: "))

if choice == 1:
    celsius = float(input("Enter the temperature in Celsius: "))
    fahrenheit = (celsius * 1.8) + 32
    print(f"The temperature in Fahrenheit is: {fahrenheit}")

elif choice == 2:
    fahrenheit = float(input("Enter the temperature in Fahrenheit: "))
    celsius = (fahrenheit - 32) / 1.8
    print(f"The temperature in Celsius is: {celsius}")

else:
    print("Invalid option entered")


    

