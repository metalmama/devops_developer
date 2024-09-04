# This is a simple calculator

# This function adds two numbers
def add(x, y):
    return x + y


# This function subtracts two numbers
def subtract(x, y):
    return x - y


# This function multiplies two numbers
def multiply(x, y):
    return x * y


# This function divides two numbers
def divide(x, y):
    return x / y


def calculator():
    print("Select operation.")
    print("1.Add")
    print("2.Subtract")
    print("3.Multiply")
    print("4.Divide")

    # Take input from the user
    choice = input("Enter choice(1/2/3/4): ")

    # Check if choice is one of the four options
    if choice in ('1', '2', '3', '4'):
        num1 = float(input("Enter first number: "))
        num2 = float(input("Enter second number: "))

        if choice == '1':
            return add(num1, num2)

        elif choice == '2':
            return subtract(num1, num2)

        elif choice == '3':
            return multiply(num1, num2)

        elif choice == '4':
            return divide(num1, num2)
    else:
        print("Invalid Input")


def print_result_function(number):
    print(number)
    if 1 < number < 50:
        print('Less than fifty')
    elif number == 50:
        print('Fifty')
    elif 50 < number < 100:
        print('Almost a  hundred')
    elif number == 100:
        print('Spot on')
    elif number > 100:
        print('Missed the spot!')
    else:
        print('Negative number')

# Takes the result of the calculation an prints it on the console
print_result_function(calculator())
