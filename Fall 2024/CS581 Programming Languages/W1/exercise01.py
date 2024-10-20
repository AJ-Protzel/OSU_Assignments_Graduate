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
