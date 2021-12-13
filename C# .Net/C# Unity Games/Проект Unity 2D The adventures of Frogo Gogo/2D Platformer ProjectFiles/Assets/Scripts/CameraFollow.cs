using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraFollow : MonoBehaviour
{
    public Transform player;
    public float cameraDistance = 30.0f;
    public float cameraHeight = 2f;

    // Start is called before the first frame update
    void Awake()
    {
        GetComponent<UnityEngine.Camera>().orthographicSize = ((Screen.height / 2) / cameraDistance);
    }

    // Update is called once per frame
    void Update()
    {
        transform.position = new Vector3(player.position.x, player.position.y + cameraHeight, transform.position.z);
    }
}
