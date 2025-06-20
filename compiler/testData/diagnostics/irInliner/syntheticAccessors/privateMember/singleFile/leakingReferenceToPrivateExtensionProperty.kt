// FIR_IDENTICAL
// IGNORE_FIR_DIAGNOSTICS
// DIAGNOSTICS: -NOTHING_TO_INLINE -NON_PUBLIC_CALL_FROM_PUBLIC_INLINE -NON_PUBLIC_INLINE_CALL_FROM_PUBLIC_INLINE
private val A.x: Int
    get() = 1
private inline fun A.privateFun1() = ::x
private inline fun A.privateFun2() = privateFun1()

class A {
    internal inline fun internalFun1() = <!IR_PRIVATE_CALLABLE_REFERENCED_BY_NON_PRIVATE_INLINE_FUNCTION_WARNING!>::x<!>
    internal inline fun internalFun2() = <!IR_PRIVATE_CALLABLE_REFERENCED_BY_NON_PRIVATE_INLINE_FUNCTION_CASCADING_WARNING!>privateFun2()<!>

    protected inline fun protectedFun1() = <!IR_PRIVATE_CALLABLE_REFERENCED_BY_NON_PRIVATE_INLINE_FUNCTION_WARNING!>::x<!>
    protected inline fun protectedFun2() = <!IR_PRIVATE_CALLABLE_REFERENCED_BY_NON_PRIVATE_INLINE_FUNCTION_CASCADING_WARNING!>privateFun2()<!>

    public inline fun publicFun1() = <!IR_PRIVATE_CALLABLE_REFERENCED_BY_NON_PRIVATE_INLINE_FUNCTION_WARNING!>::x<!>
    public inline fun publicFun2() = <!IR_PRIVATE_CALLABLE_REFERENCED_BY_NON_PRIVATE_INLINE_FUNCTION_CASCADING_WARNING!>privateFun2()<!>

    inline fun defaultFun1() = <!IR_PRIVATE_CALLABLE_REFERENCED_BY_NON_PRIVATE_INLINE_FUNCTION_WARNING!>::x<!>
    inline fun defaultFun2() = <!IR_PRIVATE_CALLABLE_REFERENCED_BY_NON_PRIVATE_INLINE_FUNCTION_CASCADING_WARNING!>privateFun2()<!>
}
