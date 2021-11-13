fun main(args: Array<String>) {
    // Visibility Modifiers

    // Public Variables: Accessible Everywhere, outside the modules as well.
    // Private Variables: Only for classes, NOT outside of class
    // protected Variables: only referencable within subclasses.
    // Internal Variables: Only Accessible within the Module.
}


open class MyModifiersDem {
    public var publicVar = "Public"
    private var privateVar = "Public"
    protected var protectedVar = "Public"
    internal var internalVar = "Public"
}

class MySubclass : MyModifiersDem() {
    fun test() {
        print(publicVar)  // Public variables can be accessed from subclasses.

        print(privateVar) // Private variables cannot be accessed from subclasses.

        print(protectedVar) // protected variables can be accessed from subclasses.

        print(internalVar) // internal variables can be accessed from subclasses.
    }
}

class AnotherClass {
    fun test() {
        val myInherited = MyModifiersDem()

        print(myInherited.publicVar) // Public variables can be accessed from other classes, even if they do not inherit.

        print(myInherited.privateVar) // Private variables cannot be accessed from  other classes.

        print(myInherited.protectedVar) // Protected variables cannot be accessed from  other classes.

        print(myInherited.internalVar) // internal variables can be accessed from other classes, even if they do not inherit.
    }
}

