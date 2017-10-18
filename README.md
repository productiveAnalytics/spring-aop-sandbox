AspectJ based Spring AOP using Spring Boot

Uses Aspects:
@Before
@After / @AfterReturning / @AfterThrowing
@Around

Syntax of Pointcut:
"execution (returnType PACKAGE.CLASS.METHOD(..))"
e.g execution (* mypackage.*.performComplexOperation(..))