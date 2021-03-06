package homecomingalpha.ederpadilla.example.com.proyectoipn.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import homecomingalpha.ederpadilla.example.com.proyectoipn.R;
import homecomingalpha.ederpadilla.example.com.proyectoipn.activitys.AlumnoPerfilActivity;
import homecomingalpha.ederpadilla.example.com.proyectoipn.activitys.EditUserProfileActivity;
import homecomingalpha.ederpadilla.example.com.proyectoipn.models.Alumnos;
import homecomingalpha.ederpadilla.example.com.proyectoipn.util.Constantes;
import homecomingalpha.ederpadilla.example.com.proyectoipn.util.Util;

/**
 * Created by ederpadilla on 09/12/16.
 */

public class CheckOutFragment extends DialogFragment {
    @BindView(R.id.fragment_et__persona_check_out)
    EditText personaQueHaraCheckOut;
    String nombre;
    String fecha;
    String hora;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /** Inflamos nuestra vista */
        View view = inflater.inflate(R.layout.fragment_checkout_alumno, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public void setValues() {

    }

    @OnClick(R.id.btn_checkout)
    public void checkOut(){
        if (personaQueHaraCheckOut.getText().toString().equals(null)){
            Util.showToast(getActivity(),getString(R.string.personaquerecoge));
        }else{
            DatabaseReference referenciaEstadoAlumno = ((AlumnoPerfilActivity)getActivity()).database.getReference(Constantes.FIREBASE_DB_STUDENTS).child(((AlumnoPerfilActivity)getActivity()).alumnoPerfil.getCodigoAlumno()).child(Constantes.FIREBASE_DB_STUDENTS_STATE);
            referenciaEstadoAlumno.setValue(Constantes.STUDENT_STATE_NOT_IN_SCHOOL);
            DatabaseReference referenciaFechalumno = ((AlumnoPerfilActivity)getActivity()).database.getReference(Constantes.FIREBASE_DB_STUDENTS).child(((AlumnoPerfilActivity)getActivity()).alumnoPerfil.getCodigoAlumno()).child(Constantes.FIREBASE_DB_STUDENTS_DATE);
            referenciaFechalumno.setValue(((AlumnoPerfilActivity)getActivity()).getDate());
            DatabaseReference referenciaHoraAlumno = ((AlumnoPerfilActivity)getActivity()).database.getReference(Constantes.FIREBASE_DB_STUDENTS).child(((AlumnoPerfilActivity)getActivity()).alumnoPerfil.getCodigoAlumno()).child(Constantes.FIREBASE_DB_STUDENTS_HOUR);
            referenciaHoraAlumno.setValue(((AlumnoPerfilActivity)getActivity()).getHour());
            DatabaseReference referenciaPersonaRecogeraAlumno = ((AlumnoPerfilActivity)getActivity()).database.getReference(Constantes.FIREBASE_DB_STUDENTS).child(((AlumnoPerfilActivity)getActivity()).alumnoPerfil.getCodigoAlumno()).child(Constantes.FIREBASE_DB_STUDENTS_WHO_GET_IT);
            referenciaPersonaRecogeraAlumno.setValue(personaQueHaraCheckOut.getText().toString());
            Util.showToast(getActivity(),getString(R.string.serealizoelcheckout));
            dismiss();
        }
    }
    public static CheckOutFragment newInstance() {
    CheckOutFragment checkOutFragment = new CheckOutFragment();
    return checkOutFragment;
    }

}