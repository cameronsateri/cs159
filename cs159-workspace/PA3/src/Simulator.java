import java.util.ArrayList;

/**
 * This file contains the Simulator class.
 * 
 * @author cameron sateri
 * @version 3/17/23
 */
public class Simulator {
    private ArrayList<VendingMachine> vmList;

    /**
     * 1 arg constructor for the Simulator class, creates ArrayList of VendingMachine objects to be tested.
     * 
     * @param vmList The pre-created ArrayList of VendingMachine objects to be tested.
     */
    public Simulator(ArrayList<VendingMachine> vmList) {
        this.vmList = new ArrayList<VendingMachine>();
        for (int i = 0; i < vmList.size(); i++) {
            this.vmList.add(vmList.get(i));
        }
    }

    /**
     * Adds a VendingMachine object to the ArrayList vmList.
     * 
     * @param vm The VendingMachine object to be added.
     */
    public void addVM(VendingMachine vm) {
        this.vmList.add(vm);
    }

    /**
     * Simulates the VendingMachine objects in the ArrayList vmList. All VendingMachine objects will receive purchases
     * from all slots a total number of parameter pCount times.
     * 
     * @param pCount The number of times that each slot in each VendingMachine will be purchased from.
     * @return The total profit received across all VendingMachine objects.
     */
    public int simulate(int pCount) {
        for (int i = 0; i < this.vmList.size(); i++) { // move through ArrayList vmList.
            for (int j = 0; j < this.vmList.get(i).getSlotCount(); j++) { // move through array slots in VendingMachine.
                for (int k = 0; k < pCount && k < Slot.SLOT_SIZE && this.vmList.get(i).nextProduct(j) != null; k++) {
                    this.vmList.get(i).buy(j);
                }
            }
        }
        return VendingMachine.totalProfit;
    }
}
