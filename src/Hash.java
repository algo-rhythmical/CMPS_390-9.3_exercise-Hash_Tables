public class Hash {
    String[] hashTable;
    int numOfSmashes;
    int tableLength;

    Hash(int tableLength){
        hashTable = new String[tableLength];
        this.tableLength = tableLength;
    }

    public void nameToHashTable(String name) {
        int nameHash;
        int hashIndex;

        nameHash = getNameHash(name);
        hashIndex = getHashIndex(tableLength, nameHash);

        if (hashTable[hashIndex] == null) {
            hashTable[hashIndex] = name;
        }
        else {
            while (hashTable[hashIndex] != null) {
                ++numOfSmashes;
                ++hashIndex;
            }
            hashTable[hashIndex] = name;
        }
    }

    int getNameHash(String name) {
        int nameHash;

        nameHash = ((name.charAt(0) - 'a')*676) + ((name.charAt(1) - 'a')*26) +
                (name.charAt(2) - 'a');
        return nameHash;
    }

    int getHashIndex(int tblLen, int hValue) {
        int hashIndex = 0;

        if (tblLen == 200) {
            hashIndex = hValue / 89;
        }
        else if (tblLen == 400) {
            hashIndex = hValue / 45;
        }
        else if (tblLen == 700) {
            hashIndex = hValue / 25;
        }
        else if(tblLen == 9000) {
            hashIndex = hValue / 2;
        }
        return hashIndex;
    }

    void showHashTable() {
        System.out.println("Hash Table:");
        for(int i = 0; i < tableLength; i++) {
            System.out.println(hashTable[i]);
        }
        System.out.println("\n"+"Number of hash clashes: " +numOfSmashes);
    }

    void namesCount() {
        int nameCount = 0;

        for (int i = 0; i < tableLength; i++) {
            if(hashTable[i] != null) {
                ++nameCount;
            }
        }
        System.out.println("There are " +nameCount+ " names in the table");
    }
}