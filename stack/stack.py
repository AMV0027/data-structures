class Stack:
    def __init__(self, capacity):
        self.array = [None] * capacity
        self.top = -1
        self.capacity = capacity

    def is_empty(self):
        return self.top == -1

    def is_full(self):
        return self.top == self.capacity - 1

    def push(self, data):
        if self.is_full():
            print(f"Stack is full. Cannot push {data}.")
            return
        self.top += 1
        self.array[self.top] = data
        print(f"Pushed {data} onto the stack")

    def pop(self):
        if self.is_empty():
            print("Stack is empty. Cannot pop.")
            return
        print(f"Popped {self.array[self.top]} from the stack")
        self.top -= 1

    def peek(self):
        if self.is_empty():
            print("Stack is empty. Cannot peek.")
            return
        print(f"Top element is {self.array[self.top]}")

    def display(self):
        if self.is_empty():
            print("Stack is empty.")
            return
        print("Stack elements:", end=" ")
        for i in range(self.top + 1):
            print(self.array[i], end=" ")
        print()

def main():
    capacity = int(input("Enter the capacity of the stack: "))
    stack = Stack(capacity)

    while True:
        print("\n1. Push\n2. Pop\n3. Peek\n4. Display\n5. Exit")
        choice = int(input("Enter your choice: "))

        if choice == 1:
            data = int(input("Enter data to push: "))
            stack.push(data)
        elif choice == 2:
            stack.pop()
        elif choice == 3:
            stack.peek()
        elif choice == 4:
            stack.display()
        elif choice == 5:
            break
        else:
            print("Invalid choice")

if __name__ == "__main__":
    main()
