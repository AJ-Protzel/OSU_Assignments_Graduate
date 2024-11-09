
public class BFHM {
    static private final int NULL = -1; // Null link
    public int[] memory; // Managed memory
    private int freeStart; // Start of free list

    public BFHM(int[] initialMemory) {
        memory = initialMemory;
        memory[0] = memory.length; // One big free block
        memory[1] = NULL; // End of free list
        freeStart = 0; // Start of free list
    }

    public int allocate(int requestSize) {
        int size = requestSize + 1; // Size with header
        int p = freeStart; // Head of free list
        int lag = NULL; // Previous block
        int bestFit = NULL; // Best-fit block
        int bestFitLag = NULL; // Previous best-fit block
        int bestFitSize = Integer.MAX_VALUE; // Size of best-fit block

        // Best-fit search: find the smallest block that fits
        while (p != NULL) {
            if (memory[p] >= size && memory[p] < bestFitSize) {
                bestFit = p; // New best-fit block
                bestFitLag = lag; // Previous best-fit block
                bestFitSize = memory[p]; // Current best-fit block size
            }
            lag = p; // Update previous block
            p = memory[p + 1]; // Move to next block
        }

        if (bestFit == NULL) // No block large enough
            throw new OutOfMemoryError();

        int nextFree = memory[bestFit + 1]; // Block after best-fit block
        int unused = memory[bestFit] - size; // Extra space
        if (unused > 1) { // More than a header's worth
            nextFree = bestFit + size; // Index of unused piece
            memory[nextFree] = unused; // Set size of unused piece
            memory[nextFree + 1] = memory[bestFit + 1]; // Link unused piece
            memory[bestFit] = size; // Reduce size of best-fit block
        }
        if (bestFitLag == NULL)
            freeStart = nextFree; // Update freeStart
        else
            memory[bestFitLag + 1] = nextFree; // Update link of previous best-fit block
        return bestFit + 1; // Usable word index
    }

    public void deallocate(int address) {
        int addr = address - 1;
        memory[addr + 1] = freeStart; // Link to free list
        freeStart = addr; // Update freeStart
    }

    public static void main(String[] args) {
        BFHM mm = new BFHM(new int[7]);
        System.out.println("Memory state: " + java.util.Arrays.toString(mm.memory));
        int a = mm.allocate(2);
        System.out.println("Memory state: " + java.util.Arrays.toString(mm.memory));
        int b = mm.allocate(1);
        System.out.println("Memory state: " + java.util.Arrays.toString(mm.memory));
        int c = mm.allocate(1);
        System.out.println("Memory state: " + java.util.Arrays.toString(mm.memory));
        mm.deallocate(a);
        System.out.println("Memory state: " + java.util.Arrays.toString(mm.memory));
        mm.deallocate(c);
        System.out.println("Memory state: " + java.util.Arrays.toString(mm.memory));

        // Best-fit succeeds, first-fit fails
        int d = mm.allocate(1); // Allocates in the smallest free block
        System.out.println("Memory state: " + java.util.Arrays.toString(mm.memory));
        int e = mm.allocate(2); // Allocates in the remaining space

        // Output the memory state for verification
        System.out.println("Memory state: " + java.util.Arrays.toString(mm.memory));
    }
}
