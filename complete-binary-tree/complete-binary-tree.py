class TreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class CompleteBinaryTree:
    def __init__(self):
        self.root = None

    def insert(self, data):
        if self.root is None:
            self.root = TreeNode(data)
            return

        queue = [self.root]
        while queue:
            current = queue.pop(0)

            if current.left is None:
                current.left = TreeNode(data)
                break
            else:
                queue.append(current.left)

            if current.right is None:
                current.right = TreeNode(data)
                break
            else:
                queue.append(current.right)

    def inorder_traversal(self, node):
        if node is None:
            return
        self.inorder_traversal(node.left)
        print(node.data, end=" ")
        self.inorder_traversal(node.right)

if __name__ == "__main__":
    tree = CompleteBinaryTree()
    tree.insert(10)
    tree.insert(20)
    tree.insert(30)
    tree.insert(40)
    tree.insert(50)

    print("Inorder Traversal of the Complete Tree: ", end="")
    tree.inorder_traversal(tree.root)
    print()
