class Queue:
    def __init__(self, size):
        self.contents = [None] * size
        self.front = 0
        self.rear = -1
        self.count = 0
        self.size = size

    def enQueue(self, element):
        if self.count == self.size:
            print("Queue is full")
            return
        self.rear = (self.rear + 1) % self.size
        self.contents[self.rear] = element
        self.count += 1

    def deQueue(self):
        if self.count == 0:
            print("Queue is empty")
            return -1000
        data = self.contents[self.front]
        self.front = (self.front + 1) % self.size
        self.count -= 1
        return data

    def display(self):
        if self.count == 0:
            print(" {}")
            return
        j = self.front
        for i in range(self.count):
            print(self.contents[j], end=" ")
            j = (j + 1) % self.size
        print()

def printMenu():
    print("Choice 1 : Enter element into Queue")
    print("Choice 2 : Delete element from Queue")
    print("Choice 3 : Display")
    print("Any other choice : Exit")

if __name__ == "__main__":
    queue = Queue(5)

    while True:
        printMenu()
        choice = int(input("Enter your choice: "))
        if choice == 1:
            data = int(input("Enter the element to be inserted/entered: "))
            queue.enQueue(data)
        elif choice == 2:
            data = queue.deQueue()
            if data != -1000:
                print("The deleted element is", data)
        elif choice == 3:
            print("The contents of the queue are", end=" ")
            queue.display()
        else:
            break
