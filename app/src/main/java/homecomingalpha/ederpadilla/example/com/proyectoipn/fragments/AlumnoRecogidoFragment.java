package homecomingalpha.ederpadilla.example.com.proyectoipn.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import homecomingalpha.ederpadilla.example.com.proyectoipn.R;
import homecomingalpha.ederpadilla.example.com.proyectoipn.activitys.AlumnoPerfilActivity;
import homecomingalpha.ederpadilla.example.com.proyectoipn.models.Alumnos;

/**
 * Created by ederpadilla on 11/12/16.
 */

public class AlumnoRecogidoFragment extends DialogFragment {
    @BindView(R.id.fragment_alumno_recogido_nombre_alumno)
    TextView nombre;
    @BindView(R.id.fragment_alumno_recogido_persona_que_recogio)
    TextView persona_que_recogio;
    @BindView(R.id.fragment_alumno_recogido_fecha)
    TextView fecha;
    @BindView(R.id.fragment_alumno_recogido_hora)
    TextView hora;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /** Inflamos nuestra vista */
        View view = inflater.inflate(R.layout.fragment_alumno_recogido, container, false);
        ButterKnife.bind(this, view);
        setValues();
        return view;
    }
    public void setValues(){
        nombre.setText(((AlumnoPerfilActivity)getActivity()).alumnoPerfil.getNombreCompletoAlumno()+getString(R.string.se_retiro_de_la_escuela));
        persona_que_recogio.setText(((AlumnoPerfilActivity)getActivity()).alumnoPerfil.getPersonaQueRecogio());
        fecha.setText(((AlumnoPerfilActivity)getActivity()).alumnoPerfil.getFecha());
        hora.setText(((AlumnoPerfilActivity)getActivity()).alumnoPerfil.getHora());
    }
    public static AlumnoRecogidoFragment newInstance() {
      AlumnoRecogidoFragment alumnoRecogidoFragment = new AlumnoRecogidoFragment();
        return alumnoRecogidoFragment;
    }
}