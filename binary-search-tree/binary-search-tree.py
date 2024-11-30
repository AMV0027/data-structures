class TreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class BinaryTree:
    def __init__(self):
        self.root = None

    def insert(self, value):
        if self.root is None:
            self.root = TreeNode(value)
        else:
            self._insert(self.root, value)

    def _insert(self, root, value):
        if value < root.data:
            if root.left is None:
                root.left = TreeNode(value)
            else:
                self._insert(root.left, value)
        else:
            if root.right is None:
                root.right = TreeNode(value)
            else:
                self._insert(root.right, value)

    def inorder(self):
        self._inorder(self.root)

    def _inorder(self, root):
        if root:
            self._inorder(root.left)
            print(root.data, end=" ")
            self._inorder(root.right)

    def preorder(self):
        self._preorder(self.root)

    def _preorder(self, root):
        if root:
            print(root.data, end=" ")
            self._preorder(root.left)
            self._preorder(root.right)

    def postorder(self):
        self._postorder(self.root)

    def _postorder(self, root):
        if root:
            self._postorder(root.left)
            self._postorder(root.right)
            print(root.data, end=" ")

    def search(self, key):
        return self._search(self.root, key)

    def _search(self, root, key):
        if root is None or root.data == key:
            return root
        if key < root.data:
            return self._search(root.left, key)
        return self._search(root.right, key)

    def delete(self, key):
        self.root = self._delete(self.root, key)

    def _delete(self, root, key):
        if root is None:
            return root
        if key < root.data:
            root.left = self._delete(root.left, key)
        elif key > root.data:
            root.right = self._delete(root.right, key)
        else:
            if root.left is None:
                return root.right
            elif root.right is None:
                return root.left
            root.data = self._find_min(root.right)
            root.right = self._delete(root.right, root.data)
        return root

    def _find_min(self, root):
        while root.left:
            root = root.left
        return root.data

if __name__ == "__main__":
    tree = BinaryTree()
    while True:
        print("1. Insert\n2. Delete\n3. Search\n4. Inorder\n5. Preorder\n6. Postorder\n7. Exit")
        choice = int(input("Enter your choice: "))
        if choice == 1:
            ele = int(input("Enter element to insert: "))
            tree.insert(ele)
        elif choice == 2:
            ele = int(input("Enter element to delete: "))
            tree.delete(ele)
        elif choice == 3:
            ele = int(input("Enter element to search: "))
            result = tree.search(ele)
            if result:
                print(f"{ele} found in the tree.")
            else:
                print(f"{ele} not found in the tree.")
        elif choice == 4:
            print("Inorder Traversal: ", end="")
            tree.inorder()
            print()
        elif choice == 5:
            print("Preorder Traversal: ", end="")
            tree.preorder()
            print()
        elif choice == 6:
            print("Postorder Traversal: ", end="")
            tree.postorder()
            print()
        elif choice == 7:
            break
        else:
            print("Invalid choice!")
