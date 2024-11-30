class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

class DoublyLinkedList:
    def __init__(self):
        self.head = None

    def insert_at_start(self, data):
        new_node = Node(data)
        if self.head:
            self.head.prev = new_node
            new_node.next = self.head
        self.head = new_node

    def insert_at_end(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            return
        temp = self.head
        while temp.next:
            temp = temp.next
        temp.next = new_node
        new_node.prev = temp

    def insert_after(self, target, data):
        temp = self.head
        while temp and temp.data != target:
            temp = temp.next
        if not temp:
            print(f"Target {target} not found in the list.")
            return
        new_node = Node(data)
        new_node.next = temp.next
        new_node.prev = temp
        if temp.next:
            temp.next.prev = new_node
        temp.next = new_node

    def delete_at_start(self):
        if not self.head:
            print("List is empty.")
            return
        self.head = self.head.next
        if self.head:
            self.head.prev = None

    def delete_at_end(self):
        if not self.head:
            print("List is empty.")
            return
        temp = self.head
        while temp.next:
            temp = temp.next
        if temp.prev:
            temp.prev.next = None
        else:
            self.head = None

    def delete_specific(self, target):
        temp = self.head
        while temp and temp.data != target:
            temp = temp.next
        if not temp:
            print(f"Target {target} not found in the list.")
            return
        if temp.prev:
            temp.prev.next = temp.next
        else:
            self.head = temp.next
        if temp.next:
            temp.next.prev = temp.prev

    def display(self):
        if not self.head:
            print("List is empty.")
            return
        temp = self.head
        print("List elements: ", end="")
        while temp:
            print(temp.data, end=" ")
            temp = temp.next
        print()

if __name__ == "__main__":
    dll = DoublyLinkedList()

    while True:
        print("1. Insert at Start\n2. Insert at End\n3. Insert After\n4. Delete at Start\n5. Delete at End\n6. Delete Specific\n7. Display\n8. Exit")
        choice = int(input("Enter your choice: "))

        if choice == 1:
            ele = int(input("Enter data to insert at start: "))
            dll.insert_at_start(ele)
        elif choice == 2:
            ele = int(input("Enter data to insert at end: "))
            dll.insert_at_end(ele)
        elif choice == 3:
            target = int(input("Enter target after which to insert: "))
            ele = int(input("Enter data to insert: "))
            dll.insert_after(target, ele)
        elif choice == 4:
            dll.delete_at_start()
        elif choice == 5:
            dll.delete_at_end()
        elif choice == 6:
            target = int(input("Enter data to delete: "))
            dll.delete_specific(target)
        elif choice == 7:
            dll.display()
        elif choice == 8:
            break
        else:
            print("Invalid choice.")
