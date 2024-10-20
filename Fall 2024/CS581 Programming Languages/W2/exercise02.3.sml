(*categorizing archer competators for a tournament at different ranges and shooting types*)

(*Enumerated Type*)
datatype BowStyle = OlympicRecurve | Traditional | Compound;
datatype SkillLevel = Beginner | Intermediate | Expert;

(*Algebraic Type*)
datatype Distance = 
    TwentyMeters
  | ThirtyMeters
  | SixtyMeters;

(*Record Type*)
type Archer = {name: string, style: BowStyle, level: SkillLevel};

(*Type Alias*)
type Target = Distance;

(*Function 1*)
fun difficulty (distance: Distance) : int =
    case distance of
        TwentyMeters => 20
      | ThirtyMeters => 30
      | SixtyMeters => 60;

(*Function 2*)
fun categorizeArcher ({name, style, level}: Archer, distance: Distance) : string =
    let val difficultyLevel = difficulty(distance)
    in name ^ " shoots at a difficulty level of " ^ Int.toString(difficultyLevel) ^ "."
    end;

(*Values*)
val archer1 = {name = "Alice", style = OlympicRecurve, level = Intermediate};
val archer2 = {name = "Bob", style = Traditional, level = Beginner};
val archer3 = {name = "Charlie", style = Compound, level = Expert};

val distance1 = TwentyMeters;
val distance2 = ThirtyMeters;
val distance3 = SixtyMeters;

val result1 = categorizeArcher(archer1, distance1);
val result2 = categorizeArcher(archer2, distance2);
val result3 = categorizeArcher(archer3, distance3);
