package edu.vassar.cmpu203.schmoodleproto1.Persistence;

import android.util.Log;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;

import edu.vassar.cmpu203.schmoodleproto1.Model.ClassDatabase;
import edu.vassar.cmpu203.schmoodleproto1.Model.EventDatabase;
import edu.vassar.cmpu203.schmoodleproto1.Model.Profile;
import edu.vassar.cmpu203.schmoodleproto1.Model.ProfileDatabase;


public class FirestoreFacade implements IPersistenceFacade {

    //private static final String SALES_COLLECTION = "SALES_COLLECTION";
    //private static final String USERS_COLLECTION = "USERS_COLLECTION";

    private static final String PROFILE_DATABASE = "PROFILE_DATABASE";
    //private static final String DASHBOARD_DATABASE = "DASHBOARD_DATABASE";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public FirestoreFacade() {
    }

    @Override
    public void createProfileIfNotExists(@NonNull Profile profile) {

        String profileName = profile.name;

        this.retrieveProfile(profileName, new DataListener<Profile>() {
            @Override
            public void onDataReceived(@NonNull Profile data) {
                Log.d("Schmoodle", "User not created");
            }

            @Override
            public void onNoDataFound() {
                db.collection(PROFILE_DATABASE).document(profileName).
                        set(profile);
            }
        });

    }

    @Override
    public void retrieveProfile(@NonNull String profileName, @NonNull DataListener<Profile> listener) {

        db.collection(PROFILE_DATABASE).document(profileName).get().
                addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                         @Override
                                         public void onSuccess(DocumentSnapshot dsnap) {
                                             if (dsnap.exists()) {
                                                 Profile profile = dsnap.toObject(Profile.class);
                                                 listener.onDataReceived(profile);
                                             } else // no user found
                                                 listener.onNoDataFound();
                                         }
                                     }
                );

    }

    @Override
    public ProfileDatabase getPD(@NonNull DataListener<ProfileDatabase> listener) {
        ProfileDatabase result = new ProfileDatabase();
        db.collection(PROFILE_DATABASE).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot qsnap) {
                        for (DocumentSnapshot dsnap : qsnap){
                            Profile profile = dsnap.toObject(Profile.class);
                            result.addProfile(profile);
                        }
                        listener.onDataReceived(result);
                    }
                });
        return result;
    }

    @Override
    public void changePass(String currname, String s) {
        DocumentReference docref = db.collection(PROFILE_DATABASE).document(currname);
        docref.update("pass", s);
    }

    @Override
    public void changeYear(String currname, int y) {
        DocumentReference docref = db.collection(PROFILE_DATABASE).document(currname);
        docref.update("year", y);
    }

    @Override
    public void changeMajor(String currname, String s) {
        DocumentReference docref = db.collection(PROFILE_DATABASE).document(currname);
        docref.update("major", s);
    }

    @Override
    public void changeHM(String currname, HashMap<String, Integer> hm) {
        DocumentReference docref = db.collection(PROFILE_DATABASE).document(currname);
        docref.update("weightChart", hm);
    }

    @Override
    public void makeNewEvent(String currname, EventDatabase eventD) {
        DocumentReference docref = db.collection(PROFILE_DATABASE).document(currname);
        docref.update("eventD", eventD);
    }

    @Override
    public void makeNewClass(String currname, ClassDatabase classDB) {
        DocumentReference docref = db.collection(PROFILE_DATABASE).document(currname);
        docref.update("classDB", classDB);
    }
}
