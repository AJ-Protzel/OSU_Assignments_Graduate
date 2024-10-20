# Adrien Protzel

import ast

code = """
# Adrien Protzel

import random

class Helldives:
    def __init__(self, bugs, bots):
        self.bugs = bugs
        self.bots = bots

    def render(self): # stub
        pass

Missions = []

for _ in range(random.randint(10+1, 20-1)):
    Missions.append(Helldives)

print(f"There are {len(Missions)} number of objects in the list.")

"""

tree = ast.parse(code)

# Formatting
ast_string = ast.dump(tree, indent=4)

# Export to file for easier reading
with open("AST_Tree.txt", "w") as file:
    file.write(ast_string)

print("AST_Tree.txt created")
