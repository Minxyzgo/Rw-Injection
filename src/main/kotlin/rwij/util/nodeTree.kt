package rwij.util

open class NodeTree(protected val children: MutableList<Node> = mutableListOf()) : MutableCollection<Node> by children {
    open fun addChild(value: Any): Node {
        val node = Node(value, this)
        children.add(node)
        return node
    }

    fun deleteChild(index: Int) = children.removeAt(index)
}

class Node(
    var value: Any,
    val root: NodeTree
) : NodeTree() {
    override fun addChild(value: Any): Node {
        val node = Node(value, root)
        children.add(node)
        return node
    }
}
