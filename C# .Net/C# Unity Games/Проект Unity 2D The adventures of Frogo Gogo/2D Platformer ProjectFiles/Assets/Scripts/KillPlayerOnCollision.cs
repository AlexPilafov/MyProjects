using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class KillPlayerOnCollision : MonoBehaviour
{

    public LevelManager levelManager;
    void Start() // Called at start
    {
        levelManager = FindObjectOfType<LevelManager>();
    }
    void Update() // Called every frame
    {

    }

    void OnCollisionEnter2D(Collision2D other) // kill player
    {
        if (other.gameObject.tag == "Player")
        {
            levelManager.RespawnPlayer();
        }
    } 
}
