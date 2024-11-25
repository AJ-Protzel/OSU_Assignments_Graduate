#include <stdio.h>
#include <string.h>

typedef struct {
    char riser[50];
    char limbs[50];
    char string[50];
    char style[50];
    int weight;
    double braceHeight;
    int stabilizer;
    int sight;
    int wristStrap;
} Bow;

Bow createBow(const char* riser, const char* limbs, const char* string, const char* style, int weight, double braceHeight, int stabilizer, int sight, int wristStrap) {
    Bow bow;
    strcpy(bow.riser, riser);
    strcpy(bow.limbs, limbs);
    strcpy(bow.string, string);
    strcpy(bow.style, style);
    bow.weight = weight;
    bow.braceHeight = braceHeight;
    bow.stabilizer = stabilizer;
    bow.sight = sight;
    bow.wristStrap = wristStrap;
    return bow;
}

const char* getRiser(Bow* bow) { return bow->riser; }
const char* getLimbs(Bow* bow) { return bow->limbs; }
const char* getString(Bow* bow) { return bow->string; }
const char* getStyle(Bow* bow) { return bow->style; }
int getWeight(Bow* bow) { return bow->weight; }
double getBraceHeight(Bow* bow) { return bow->braceHeight; }
int hasStabilizer(Bow* bow) { return bow->stabilizer; }
int hasSight(Bow* bow) { return bow->sight; }
int hasWristStrap(Bow* bow) { return bow->wristStrap; }

void setRiser(Bow* bow, const char* riser) { strcpy(bow->riser, riser); }
void setLimbs(Bow* bow, const char* limbs) { strcpy(bow->limbs, limbs); }
void setString(Bow* bow, const char* string) { strcpy(bow->string, string); }
void setStyle(Bow* bow, const char* style) { strcpy(bow->style, style); }
void setWeight(Bow* bow, int weight) { bow->weight = weight; }
void setBraceHeight(Bow* bow, double braceHeight) { bow->braceHeight = braceHeight; }
void setStabilizer(Bow* bow, int stabilizer) { bow->stabilizer = stabilizer; }
void setSight(Bow* bow, int sight) { bow->sight = sight; }
void setWristStrap(Bow* bow, int wristStrap) { bow->wristStrap = wristStrap; }

double calculateAverageWeight(Bow bows[], int size) {
    int totalWeight = 0;
    for (int i = 0; i < size; i++) {
        totalWeight += getWeight(&bows[i]);
    }
    return (double) totalWeight / size;
}

int main() {
    Bow bows[3];
    bows[0] = createBow("Carbon Fiber", "Composite", "Dacron", "Olympic", 45, 7.5, 1, 1, 1);
    bows[1] = createBow("Wood", "Bamboo", "Dacron", "Traditional", 35, 7.0, 0, 0, 0);
    bows[2] = createBow("Aluminum", "Fiberglass", "Horse Hair", "Compound", 50, 6.5, 1, 1, 0);

    double averageWeight = calculateAverageWeight(bows, 3);
    printf("Average weight of bows: %.2f\n", averageWeight);

    return 0;
}
