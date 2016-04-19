package jdo589.welcometout;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class SpinnerScreen extends AppCompatActivity {

    //initialize some variables
    private String[] arraySpinner;
    MediaPlayer mySound;
    int paused;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_screen);

        // initializes the global variables and fragment to empty
        emptyInfo();
        updateFragment();

        //set values in spinner and create the adapter and listener
        this.arraySpinner = new String[]{
                "Please choose an option:", "Introductory Video", "Blanton Museum of Art", "Jester Center", "Main Building", "Perry Castaneda Library", "Student Activity Center", "Fight Song"
        };
        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, arraySpinner);
        s.setAdapter(adapter);
        s.setSelection(0, false);
        s.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                // update information to display in fragment depending on spinner choice
                updateRes(position);
                updateFragment();
                ScrollView scrview = (ScrollView) findViewById(R.id.scrollView);
                scrview.scrollTo(0, 0);

                if (arraySpinner[position].equalsIgnoreCase("Fight Song")) {
                    //play music
                    play();
                }

                else if (arraySpinner[position].equalsIgnoreCase("Introductory Video")){
                    if (mySound == null){
                        //we are okay
                    }
                    // stop the music
                    else if (mySound.isPlaying()){
                        stop();
                    }
                    Intent intent = new Intent(SpinnerScreen.this,WelcomeVideo.class);
                    startActivity(intent);
                }
            }

            // if the user does not select anything, do nothing
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }

        });

    }

    // updates the global variables with the correct information depending on the spinner choice
    public void updateRes(int position) {
        String[] names = new String[]{
                "Please choose an option:", "Introductory Video", "Blanton Museum of Art", "Jester Center", "Main Building", "Perry Castaneda Library", "Student Activity Center", "Fight Song"
        };

        String[] addresses = new String[]{
                "", "", "200 E Martin Luther King Jr Blvd,\nAustin, TX 78701", "201 East 21st Street\nAustin, TX 78705", "110 Inner Campus Dr,\nAustin, TX 78712", "101 E 21st St,\nAustin, TX 78712", "2201 Speedway, Austin\nTX 78712", "Here is our traditonial fight song that is played at all athletic events!"
        };

        String[] informations = new String[]{
                "", "", "The Jack S. Blanton Museum of Art (often referred to as the Blanton or the BMA) at The University of Texas at Austin is one of the largest university art museums in the U.S. with 189,340 square feet devoted to temporary exhibitions, permanent collection galleries, storage, administrative offices, classrooms, a print study room, an auditorium, shop, and cafe. The Blanton's permanent collection consists of almost 18,000 works, with significant holdings of modern and contemporary art, Latin American art, Old Master paintings, and prints and drawings from Europe, the United States, and Latin America.",
                "Jester Center or Jester Center Residence Halls is a co-educational residence hall at The University of Texas at Austin, built in 1969. The residence hall was named after Beauford H. Jester, who served as the Governor of Texas from 1947 until 1949.",
                "The Main Building (known colloquially as The Tower) is a structure at the center of the University of Texas at Austin campus in Downtown Austin, Texas, United States. The Main Building's 307-foot (94 m) tower has 30 floors and is one of the most recognizable symbols of the university and the city.",
                "The Perry–Castañeda Library (PCL) is the main central library of the University of Texas at Austin library system in Austin, Texas. PCL is located at 21st Street and Speedway in Austin, TX. The UT Austin campus library system holds nearly eight million volumes, ranking it as the fifth largest library among academic institutions in the United States, and the eleventh largest overall in the country.",
                "he building has transformed a portion of the East Mall into the “campus living room.” Aligning with priorities articulated by the students, the Student Activity Center is focused on activity spaces, including a 5,000-SF ballroom, a 500-seat auditorium, a black box theater, 12 student conference/meeting rooms, student organization offices, a student government chamber, and outdoor gathering spaces. There are ample study lounges and informal gathering areas scattered throughout the facility as well. An indoor food court and a coffee bar open to more than 46,000 SF of landscaped courtyards, substantially increasing the seating and providing an enjoyable dining experience in the moderate Austin climate. The building also includes two upper floors of academic space for the adjacent College of Liberal Arts, which is connected by a sky bridge.",
                "Texas Fight, Texas Fight,\n" +
                        "And it’s goodbye to A&M.\n" +
                        "Texas Fight, Texas Fight,\n" +
                        "And we’ll put over one more win.\n" +
                        "Texas Fight, Texas Fight,\n" +
                        "For it’s Texas that we love best.\n" +
                        "Hail, Hail, The gang’s all here,\n" +
                        "And it’s good-bye to all the rest! (YELL)\n" +
                        "Yea Orange! Yea White!\n" +
                        "Yea Longhorns! Fight! Fight! Fight!\n" +
                        "Texas Fight! Texas Fight,\n" +
                        "Yea Texas Fight!\n" +
                        "Texas Fight! Texas Fight,\n" +
                        "Yea Texas Fight!\n" +
                        "The Eyes of Texas are upon you,\n" +
                        "All the livelong day.\n" +
                        "The Eyes of Texas are upon you,\n" +
                        "You cannot get away.\n" +
                        "Texas Fight, Texas Fight,\n" +
                        "For it’s Texas that we love best.\n" +
                        "Hail, Hail, The gang’s all here,\n" +
                        "And it good-bye to all the rest!"
        };

        String[] facts = new String[]{
                "", "", "The Blanton's permanent collection of almost 18,000 works is recognized for its European paintings, prints and drawings, and modern and contemporary American and Latin American art.",
                "According to student folklore, the structure was designed by an architect who specialized in prison design, specifically women's prisons due to the shower heads being placed fairly low (folklore c. at least 1983). A true fact is that Jester once had its own ZIP code, 78787; this was changed c. 1986. Currently, the University as a whole makes up a large part of the 78705 ZIP code, and Jester residence hall serves as a polling place for Precinct 148 in Texas Congressional District 21.",
                "The Tower usually appears illuminated in white light in the evening, but is lit in various color schemes for special occasions, including athletic victories and academic accomplishments. To mark more somber events, such as the passing of a former president of the university, the Tower remains darkened with a soft grey glow through the night.",
                "The PCL is an example of brutalist architecture and has been recognized as Austin's best example of this architectural style.",
                "The Student Activity Center serves as a place to see and be seen, a place for meeting, and a place for building community. It balances the need for timelessness and integration with the historic campus while being open, transparent and welcoming.",
                "Note: The line, “Hail, Hail, the gang’s all here” is usually replaced with “Give ’em hell, Give ’em hell, Go Horns Go!” or “Give ’em hell, Give ’em hell, Make 'em eat shit!”"
        };

        String[] pics = new String[]{
                "defimg", "defimg", "blanton", "jester", "tower", "pcl", "sac", "hookem"
        };

        ((AppContext) this.getApplication()).setBuildingAddress(addresses[position]);
        ((AppContext) this.getApplication()).setBuildingFact(facts[position]);
        ((AppContext) this.getApplication()).setBuildingInformation(informations[position]);
        ((AppContext) this.getApplication()).setBuildingName(names[position]);
        ((AppContext) this.getApplication()).setBuildingPic(pics[position]);
    }

    // sets the global variables for the fragment visual to empty strings
    public void emptyInfo() {
        ((AppContext) this.getApplication()).setBuildingAddress("");
        ((AppContext) this.getApplication()).setBuildingFact("");
        ((AppContext) this.getApplication()).setBuildingInformation("");
        ((AppContext) this.getApplication()).setBuildingName("");
        ((AppContext) this.getApplication()).setBuildingPic("");
    }

    //updates visuals of fragment
    public void updateFragment() {
        //gets text views and image view in fragment
        TextView buildingInfo = (TextView) findViewById(R.id.buildingInfo);
        TextView buildingName = (TextView) findViewById(R.id.buildingName);
        TextView buildingAddress = (TextView) findViewById(R.id.buildingAddress);
        TextView buildingFact = (TextView) findViewById(R.id.buildingFact);
        ImageView buildingPic = (ImageView) findViewById(R.id.buildingPic);

        //sets the text views to the correct global variable values
        buildingName.setText(((AppContext) this.getApplication()).getBuildingName());
        buildingInfo.setText(((AppContext) this.getApplication()).getBuildingInformation());
        buildingAddress.setText(((AppContext) this.getApplication()).getBuildingAddress());
        buildingFact.setText(((AppContext) this.getApplication()).getBuildingFact());

        //get the image resource and update it
        String picname = ((AppContext) this.getApplication()).getBuildingPic();
        int id = getResources().getIdentifier(picname, "drawable", getPackageName());
        buildingPic.setImageResource(id);
    }


    //pauses music
    public void pause() {
        mySound.pause();
        paused=mySound.getCurrentPosition();
    }

    //stops music
    public void stop() {
        mySound.release();
        mySound=null;

    }

    //plays music
    public void play() {
        if (mySound == null) {
            mySound = MediaPlayer.create(this, R.raw.fightsong);
            mySound.start();
        }
        else if (!mySound.isPlaying()){
            mySound.seekTo(paused);
            mySound.start();
        }
    }
//
//    @Override
//    protected void onPause(){
//        super.onPause();
//        mySound.pause();
//        paused=mySound.getCurrentPosition();
//    }
//
//    protected void onResume(){
//        super.onResume();
//        mySound.seekTo(paused);
//        mySound.start();
//        }
    }

