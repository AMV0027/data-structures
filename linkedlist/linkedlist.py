class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None

    def create_node(self, data):
        return Node(data)

    def append(self, data):
        new_node = self.create_node(data)
        if self.head is None:
            self.head = new_node
            return
        temp = self.head
        while temp.next is not None:
            temp = temp.next
        temp.next = new_node

    def append_at_beginning(self, data):
        new_node = self.create_node(data)
        new_node.next = self.head
        self.head = new_node

    def append_at_position(self, data, position):
        new_node = self.create_node(data)
        if position == 1:
            new_node.next = self.head
            self.head = new_node
            return
        temp = self.head
        for _ in range(1, position - 1):
            if temp is None:
                return
            temp = temp.next
        if temp is None:
            return
        new_node.next = temp.next
        temp.next = new_node

    def delete_at_beginning(self):
        if self.head is None:
            return
        self.head = self.head.next

    def delete_at_end(self):
        if self.head is None:
            return
        if self.head.next is None:
            self.head = None
            return
        temp = self.head
        while temp.next.next is not None:
            temp = temp.next
        temp.next = None

    def delete_at_position(self, position):
        if self.head is None:
            return
        if position == 1:
            self.head = self.head.next
            return
        temp = self.head
        for _ in range(1, position - 1):
            if temp is None:
                return
            temp = temp.next
        if temp is None or temp.next is None:
            return
        temp.next = temp.next.next

    def delete_data(self, data):
        if self.head is None:
            return
        if self.head.data == data:
            self.head = self.head.next
            return
        temp = self.head
        while temp.next is not None and temp.next.data != data:
            temp = temp.next
        if temp.next is None:
            return
        temp.next = temp.next.next

    def search(self, data):
        position = 1
        temp = self.head
        while temp is not None:
            if temp.data == data:
                print(f"Data {data} found at position {position}")
                return
            temp = temp.next
            position += 1
        print(f"Data {data} not found")

    def display(self):
        temp = self.head
        while temp is not None:
            print(f"{temp.data} -> ", end="")
            temp = temp.next
        print("NULL")

def main():
    linked_list = LinkedList()
    while True:
        print("\n1. Append\n2. Append at Beginning\n3. Append at Position\n")
        print("4. Delete at Beginning\n5. Delete at End\n6. Delete at Position\n")
        print("7. Delete Data\n8. Search\n9. Display\n10. Exit")
        choice = int(input("Enter your choice: "))

        if choice == 1:
            data = int(input("Enter data to append: "))
            linked_list.append(data)
        elif choice == 2:
            data = int(input("Enter data to append at beginning: "))
            linked_list.append_at_beginning(data)
        elif choice == 3:
            data = int(input("Enter data to append: "))
            position = int(input("Enter position: "))
            linked_list.append_at_position(data, position)
        elif choice == 4:
            linked_list.delete_at_beginning()
        elif choice == 5:
            linked_list.delete_at_end()
        elif choice == 6:
            position = int(input("Enter position to delete: "))
            linked_list.delete_at_position(position)
        elif choice == 7:
            data = int(input("Enter data to delete: "))
            linked_list.delete_data(data)
        elif choice == 8:
            data = int(input("Enter data to search: "))
            linked_list.search(data)
        elif choice == 9:
            linked_list.display()
        elif choice == 10:
            break
        else:
            print("Invalid choice")

if __name__ == "__main__":
    main()
