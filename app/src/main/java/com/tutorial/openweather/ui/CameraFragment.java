package com.tutorial.openweather.ui;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.tutorial.openweather.CameraFragmentListener;
import com.tutorial.openweather.R;
import com.tutorial.openweather.databinding.FragmentCameraBinding;

import static androidx.core.content.ContextCompat.checkSelfPermission;


public class CameraFragment extends Fragment implements CameraFragmentListener
{
    private static final String TAG = "CameraFragment";
    private static final int RC_CAMERA_REQUEST = 100;
    private static final int RC_CAMERA_PERMISSION = 200;
    private FragmentCameraBinding binding;


    public CameraFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        binding = FragmentCameraBinding.inflate(inflater, container, false);
        binding.setListener(this);
        return binding.getRoot();
    }

    @Override
    public void takePhotoClicked()
    {
        if (checkSelfPermission(requireContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, RC_CAMERA_PERMISSION);
        } else
        {
            openCamera();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == RC_CAMERA_PERMISSION)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(requireContext(), "camera permission granted", Toast.LENGTH_LONG).show();
                openCamera();
            } else
            {
                Toast.makeText(requireContext(), "camera permission denied", Toast.LENGTH_LONG).show();

            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: called");
        if (requestCode == RC_CAMERA_REQUEST && resultCode == Activity.RESULT_OK)
        {
            if (data != null && data.getExtras() != null)
            {
                Log.d(TAG, "onActivityResult: data is NOT NULL");
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                navigateToMainScreen(bitmap);

            } else
            {
                Log.d(TAG, "onActivityResult: data is NULL");
            }
        }
    }

    private void navigateToMainScreen(Bitmap bitmap)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("bitmap", bitmap);
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_cameraFragment_to_mainFragment, bundle);
    }

    private void openCamera()
    {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, RC_CAMERA_REQUEST);
    }
}