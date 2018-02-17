package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final String ScoreA = "A";
    static final String ScoreB = "B";
    static final String countA = "C";
    static final String countB = "D";
    static final String winnerView = "E";
    String win;
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int counterA = 0;
    int counterB = 0;
    TextView scoreViewa;
    TextView scoreViewb;
    TextView winView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            scoreTeamA = savedInstanceState.getInt(ScoreA);
            scoreTeamB = savedInstanceState.getInt(ScoreB);
            counterA = savedInstanceState.getInt(countA);
            counterB = savedInstanceState.getInt(countB);
            win = savedInstanceState.getString(winnerView);
        }
        setContentView(R.layout.activity_main);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        if (win != null)
            displayWin(win);
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(ScoreA, scoreTeamA);
        savedInstanceState.putInt(ScoreB, scoreTeamB);
        savedInstanceState.putInt(countA, counterA);
        savedInstanceState.putInt(countB, counterB);
        winView = findViewById(R.id.winview);
        win = winView.getText().toString();
        savedInstanceState.putString(winnerView, win);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * This method is called when the +3 for Team A is clicked.
     */
    public void plus3TeamA(View view) {
        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
        counterA++;
        checknum(counterA);
    }

    /**
     * This method is called when the +2 for Team Ais clicked.
     */
    public void plus2TeamA(View view) {
        scoreTeamA += 2;
        displayForTeamA(scoreTeamA);
        counterA++;
        checknum(counterA);
    }

    /**
     * This method is called when the freethrow for Team A is clicked.
     */
    public void freethrowTeamA(View view) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
        counterA++;
        checknum(counterA);
    }

    /**
     * This method is called when the +3 for Team B is clicked.
     */
    public void plus3TeamB(View view) {
        scoreTeamB += 3;
        displayForTeamB(scoreTeamB);
        counterB++;
        checknum(counterB);
    }

    /**
     * This method is called when the +2 for Team B is clicked.
     */
    public void plus2TeamB(View view) {
        scoreTeamB += 2;
        displayForTeamB(scoreTeamB);
        counterB++;
        checknum(counterB);
    }

    /**
     * This method is called when the freethrow for Team B is clicked.
     */
    public void freethrowTeamB(View view) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
        counterB++;
        checknum(counterB);
    }

    /**
     * Function to reset given score for Teams.
     */
    public void resetscore(View view) {
        reset(0);
    }

    /**
     * Function to find the winner for Teams.
     */
    public void finish(View view) {
        if (scoreTeamA > scoreTeamB) {
            displayWin(getString(R.string.TeamA));
        } else if (scoreTeamA < scoreTeamB) {
            displayWin(getString(R.string.TeamB));
        } else
            displayWin(getString(R.string.Tie));

    }

    public void rules(View view) {
        Toast.makeText(getApplicationContext(), getString(R.string.rules), Toast.LENGTH_SHORT).show();
    }

    /**
     * Function to find the winner for Teams.
     */
    private void checknum(int counter) {
        if (counter > 9) {
            Toast.makeText(getApplicationContext(), getString(R.string.GameOver), Toast.LENGTH_SHORT).show();
            if (scoreTeamA > scoreTeamB) {
                displayWin(getString(R.string.TeamA));
            } else
                displayWin(getString(R.string.TeamB));
        }
    }

    /**
     * Resets the given score for both Teams.
     */
    private void reset(int score) {
        scoreTeamA = score;
        scoreTeamB = score;
        counterA = score;
        counterB = score;
        scoreViewa = findViewById(R.id.team_a_score);
        scoreViewb = findViewById(R.id.team_b_score);
        winView = findViewById(R.id.winview);
        winView.setText("");
        scoreViewa.setText(String.valueOf(score));
        scoreViewb.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team A.
     */
    private void displayForTeamA(int score) {
        scoreViewa = findViewById(R.id.team_a_score);
        scoreViewa.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team A.
     */
    private void displayForTeamB(int score) {
        scoreViewb = findViewById(R.id.team_b_score);
        scoreViewb.setText(String.valueOf(score));
    }

    /**
     * Displays the winner from both Teams.
     */
    private void displayWin(String team) {
        winView = findViewById(R.id.winview);
        winView.setText(String.valueOf(team));
    }
}