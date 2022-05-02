package problems.airplane;

import java.util.*;

/*
  This class contains code for simulating a small airport.  The airport currently has
  only one runway.  The simulation runs for a given amount of time, in order to help
  us determine if another runway is justified at this time.

  Written by: Stuart Hansen
  Date: March 20, 2007
*/
public class AirportSimulation {

    public final static int SIMULATION_TIME = 100;  // the total number of minutes for the simulation

    private Queue<Plane> takeOffQ;        // the queue of planes waiting to takeoff
    private Queue<Plane> landingQ;        // the queue of planes waiting to land
    private LinkedList<Plane> allPlanes;  // all the active planes in the simulation

    private BooleanSource wantsToTakeOff; // a boolean generator to help create new planes
    private BooleanSource wantsToLand;    // a boolean generator to help create new planes

    private Runway runway; // the runway object

    // The following variables are used to collect stats on the simulation
    int totalTakeOffWait;  // total time planes have waited to takeoff
    int totalLandingWait;  // total time planes have waited to land

    int totalPlanesLanded; // total number of planes that have landed
    int totalPlanesTakenOff;  // total number of planes that have taken off

    int avgLandingQueueSize;
    int avgTakeOffQueueSize;
    int avgAllPlanesQueueSize;
    int avgCounter;
    int avgBusyCounter;


    // the constructor
    // Place the constructor here for Checkpoint #3.
    public AirportSimulation() {
        wantsToLand = new BooleanSource(0.25);
        wantsToTakeOff = new BooleanSource(0.1);

        runway = new Runway();

        takeOffQ = new LinkedList<Plane>();
        landingQ = new LinkedList<Plane>();
        allPlanes = new LinkedList<Plane>();

        totalTakeOffWait = 0;
        totalLandingWait = 0;

        totalPlanesLanded = 0;
        totalPlanesTakenOff = 0;

        avgLandingQueueSize = 0;
        avgTakeOffQueueSize = 0;
        avgAllPlanesQueueSize = 0;
        avgCounter = 0;
        avgBusyCounter = 0;
    }

    /* This is the driver method for the simulation.  It runs through the simulation
        updating the planes, runway and summary statistics
     */
    public void run() {

        for (int t = 0; t <= SIMULATION_TIME; t++) {
            // Check if a new plane wants to takeoff
            if (wantsToTakeOff.query()) {
                Plane p = new Plane();
                takeOffQ.offer(p);
                allPlanes.add(p);
            }

            // Check if a new plane wants to land
            // Place code here for checkpoint #3, to see if any planes
            // want to land.  Hint: This code closely parallels checking
            // if any planes want to take off.
            if (wantsToLand.query()) {
                Plane p = new Plane();
                landingQ.offer(p);
                allPlanes.add(p);
            }
            // Process plane on the runway
            if (runway.isClear()) {
                // Place code here for Checkpoint #3.
                // First check if any planes want to land, since landing
                // takes priority over taking off.  If there is a plane that
                // wants to land,
                // 1. remove it from the landingQ and assign it
                //    to the runway, with the action of "Landing".
                // 2. remove it from allPlanes.
                // 3. Add its waitTime to totalLandingWait
                // 4. Add 1 to totalPlanesLanded.

                // else if there is a plane waiting to take off:
                // - take action appropriate to taking off.  This is
                //   completely parallel to landing.

                // If planes want to land
                if (landingQ.peek() != null) {
                    // remove from the landingQ and assign it
                    Plane landingPlane = landingQ.poll();
                    runway.assignPlane(landingPlane, PlaneAction.Landing);

                    // remove from the allPlanes
                    allPlanes.remove(landingPlane);

                    // Add it's waitTime to the totalLandingWait
                    totalLandingWait += landingPlane.getLandingTime();

                    //Add 1 to totalPlanesLanded
                    totalPlanesLanded++;
                } else if (takeOffQ.peek() != null) {
                    // remove from the landingQ and assign it
                    Plane takeoffPlane = takeOffQ.poll();
                    runway.assignPlane(takeoffPlane, PlaneAction.TakingOff);

                    // remove from the allPlanes
                    allPlanes.remove(takeoffPlane);

                    // Add it's waitTime to the totalTakeOffWait
                    totalTakeOffWait += takeoffPlane.getTakeOffTime();

                    //Add 1 to planes taken off
                    totalPlanesTakenOff++;
                }
            } else {
                runway.update();
            }

            // Add to the wait time of all remaining planes
            Iterator<Plane> it = allPlanes.iterator();
            while (it.hasNext()) {
                Plane p = it.next();
                p.updateWaitTime(totalTakeOffWait);
                avgBusyCounter++;
            }

            avgLandingQueueSize += landingQ.size();
            avgTakeOffQueueSize += takeOffQ.size();
            avgAllPlanesQueueSize += allPlanes.size();
            avgCounter++;
        }
    }

    /* This method prints a brief report summarizing statistics about the simulations */
    public void report() {
        System.out.println(totalPlanesLanded + " planes have landed.");
        System.out.println(totalPlanesTakenOff + " planes have taken off.");
        System.out.println(landingQ.size() + " planes still waiting to land.");
        System.out.println(takeOffQ.size() + " planes still waiting to takeoff.");

        System.out.println(1.0 * totalTakeOffWait / SIMULATION_TIME + " average take off wait time.");
        System.out.println(1.0 * totalLandingWait / SIMULATION_TIME + " average landing wait time.");

        System.out.printf("Average size of the landingQ: %s\r\n", avgLandingQueueSize / avgCounter);
        System.out.printf("Average size of the takeOffQ: %s\r\n", avgTakeOffQueueSize / avgCounter);
        System.out.printf("Average size of the allPlanes: %s\r\n", avgAllPlanesQueueSize / avgCounter);
        System.out.printf("Percent Busy: %s\r\n", 1.0 - ((double) totalPlanesLanded + (double) totalPlanesTakenOff) / (double) avgCounter);

    }


    public static void main(String[] args) {
        AirportSimulation sim = new AirportSimulation();
        sim.run();
        sim.report();
    }
}