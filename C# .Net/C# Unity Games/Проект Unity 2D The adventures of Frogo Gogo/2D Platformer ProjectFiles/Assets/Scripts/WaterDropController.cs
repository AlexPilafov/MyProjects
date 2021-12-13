using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class WaterDropController : MonoBehaviour
{

    public float speed;
    public PlayerController2D player;
    public int pointsOnEnemyKill;


    // Start is called before the first frame update
    void Start()
    {
        player = FindObjectOfType<PlayerController2D>();
        if (player.GetComponent<SpriteRenderer>().flipX == true)
            speed = -speed;

    }

    // Update is called once per frame
    void Update()
    {
        GetComponent<Rigidbody2D>().velocity = new Vector2(speed, GetComponent<Rigidbody2D>().velocity.y);

        

    }

    private void OnTriggerEnter2D(Collider2D other)
    {
        if (other.tag == "Enemy")
        {
            Destroy(other.gameObject);
            Destroy(gameObject);
            ScoreManager.AddPoints(pointsOnEnemyKill);
        }
        if (other.tag == "Ground" || other.tag == "Trap")
        {
            Destroy(gameObject);
        }
    }
}
