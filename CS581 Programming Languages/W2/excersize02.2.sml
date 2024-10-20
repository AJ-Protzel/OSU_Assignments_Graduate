fun isEven(x:int): bool = x mod 2 = 0;
fun select(l:'a list, f:'a -> bool): 'a list = List.filter f l;

val numbers: int list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
select(numbers, isEven);

val evenNumbers: int list = select(numbers, isEven);

