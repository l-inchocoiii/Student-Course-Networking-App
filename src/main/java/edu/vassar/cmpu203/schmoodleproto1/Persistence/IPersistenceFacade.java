package edu.vassar.cmpu203.schmoodleproto1.Persistence;
import androidx.annotation.NonNull;

import com.google.firebase.firestore.util.Listener;

import java.util.HashMap;

import edu.vassar.cmpu203.schmoodleproto1.Model.ClassDatabase;
import edu.vassar.cmpu203.schmoodleproto1.Model.EventDatabase;
import edu.vassar.cmpu203.schmoodleproto1.Model.Profile;
import edu.vassar.cmpu203.schmoodleproto1.Model.ProfileDatabase;


public interface IPersistenceFacade {

    /**
     * Interface that code interested in receiving ledger data must implement.
     */
    interface DataListener<T>{
        void onDataReceived(@NonNull T data);
        void onNoDataFound();
    }

    interface BinaryResultListener {
        void onYesResult();
        void onNoResult();
    }

    //yes comment
//    void saveProfile(@NonNull Profile profile);
    void createProfileIfNotExists(@NonNull Profile profile);
    void retrieveProfile(@NonNull String profileName, @NonNull DataListener<Profile> listener);
    ProfileDatabase getPD(@NonNull DataListener<ProfileDatabase> listener);
    void changePass(String currname, String s);
    void changeYear(String currname,  int y);
    void changeMajor(String currname, String s);
    void changeHM(String currname, HashMap<String, Integer> hm);
    void makeNewEvent(String currname, EventDatabase eventD);
    void makeNewClass(String currname, ClassDatabase classDB);





        // ledger related
//    void saveSale(@NonNull Sale sale);
//    void retrieveLedger(@NonNull DataListener<Ledger> listener);
//
//    // authentication related
//    void createUserIfNotExists(@NonNull User user, @NonNull BinaryResultListener listener);
//    void retrieveUser(@NonNull String username, @NonNull DataListener<User> listener);
}

