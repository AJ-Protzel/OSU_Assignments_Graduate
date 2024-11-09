
public class HeapManager {
    static private final int NULL = -1; // Null link
    public int[] memory; // Managed memory
    private int freeStart; // Start of free list

    /**
     * HeapManager constructor.
     * @param initialMemory int[] of memory to manage
     */
    public HeapManager(int[] initialMemory) {
        memory = initialMemory;
        memory[0] = memory.length; // One big free block
        memory[1] = NULL; // End of free list
        freeStart = 0; // Start of free list
    }

    /**
     * Allocate a block and return its address.
     * @param requestSize int size of block, > 0
     * @return block address
     * @throws OutOfMemoryError if no block big enough
     */
    public int allocate(int requestSize) {
        int size = requestSize + 1; // Size with header
        int p = freeStart; // Head of free list
        int lag = NULL;
        while (p != NULL && memory[p] < size) {
            lag = p; // Previous p
            p = memory[p + 1]; // Next block
        }
        if (p == NULL) // No block large enough
            throw new OutOfMemoryError();
        int nextFree = memory[p + 1]; // Block after p
        int unused = memory[p] - size; // Extra space
        if (unused > 1) { // More than a header's worth
            nextFree = p + size; // Unused piece
            memory[nextFree] = unused; // Fill size
            memory[nextFree + 1] = memory[p + 1]; // Fill link
            memory[p] = size; // Reduce size
        }
        if (lag == NULL) freeStart = nextFree; // Update freeStart
        else memory[lag + 1] = nextFree; // Update link
        return p + 1; // Usable word index
    }

    /**
     * Deallocate an allocated block.
     * @param address int address of the block
     */
    public void deallocate(int address) {
        int addr = address - 1;
        memory[addr + 1] = freeStart; // Link to free list
        freeStart = addr; // Update freeStart
    }
}
