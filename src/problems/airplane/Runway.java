package problems.airplane;

/*
  This class contains code to model a runway.
  The runway either is empty, or has a plane on it.
  The plane remains on the runway for the amount of time needed
  to either take off or land.

  Written by: Stuart Hansen
  Date: March 20, 2007
*/
public class Runway
{
    private Plane plane;  // the plane on the runway
    //private String action; // Landing or Taking off
    private PlaneAction action;
    private int time;   // counts the time the plane is on the runway

    /* A method to determine if the runway is clear */
    public boolean isClear()
    {
        return (plane == null ? true : false);  // replace this line for checkpoint #2.
    }

    /* This method assigns a plane to the runway */
    //public void assignPlane(Plane plane, String action)
    public void assignPlane(Plane plane, PlaneAction action)
    {
        if (this.plane != null)
            throw new RuntimeException
                    ("Plane crash!! Multiple planes on the runway at the same time.");

        // Place code here for checkpoint #2.
        time = 0;
        this.plane = plane;
        this.action = action;
    }

    /* This method clears the runway at the appropriate time */
    public void update()
    {
        // Place code here for checkpoint #2.
        // Your code should first add one to time.
        // Then it should check:
        //    If the current action is "Landing" and the plane's
        //       landing time is up, set plane to null
        //    If the current action is "TakingOff" and the plane's
        //       take off time is up, set plane to null

        time++;
        //System.out.printf( "time is %s, landing time is %s, take off time is %s\r\n", time, plane != null ? plane.getLandingTime() : "" , plane != null ?  plane.getTakeOffTime() : "" );

        if( action == PlaneAction.Landing )
            if(  time >= plane.getLandingTime() )
            {
                plane = null;
                action = PlaneAction.None;
            }

        if( action == PlaneAction.TakingOff)
            if( time >= plane.getTakeOffTime() )
            {
                plane = null;
                action = PlaneAction.None;
            }
    }

    public static void main( String [] args)
    {
        Runway r = new Runway();
        Plane [] p = new Plane[2];
        p[0] = new Plane();
        p[1] = new Plane();

        System.out.printf( "Runway is %s. Should be %s.\r\n", r.isClear() ? "clear" : " occupied", "clear" );
        r.assignPlane(p[0], PlaneAction.Landing);
        System.out.printf( "Runway is %s. Should be %s.\r\n", r.isClear() ? "clear" : " occupied", "occupied" );
        r.update();
        System.out.printf( "Runway is %s. Should be %s.\r\n", r.isClear() ? "clear" : " occupied", "occupied" );
        r.update();
        System.out.printf( "Runway is %s. Should be %s.\r\n", r.isClear() ? "clear" : " occupied", "clear" );

        r.assignPlane(p[1], PlaneAction.TakingOff);
        System.out.printf( "Runway is %s. Should be %s.\r\n", r.isClear() ? "clear" : " occupied", "occupied" );
        r.update();
        System.out.printf( "Runway is %s. Should be %s.\r\n", r.isClear() ? "clear" : " occupied", "occupied" );
        r.update();
        System.out.printf( "Runway is %s. Should be %s.\r\n", r.isClear() ? "clear" : " occupied", "occupied" );
        r.update();
        System.out.printf( "Runway is %s. Should be %s.\r\n", r.isClear() ? "clear" : " occupied", "clear" );

    }

}

