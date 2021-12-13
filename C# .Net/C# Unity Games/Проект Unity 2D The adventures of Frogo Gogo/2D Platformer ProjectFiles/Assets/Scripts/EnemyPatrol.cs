using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyPatrol : MonoBehaviour
{
    public float moveSpeed;
    public bool moveRight;

    Rigidbody2D rb2d;

    public Transform wallCheck;
    public float wallCheckRadius;
    public LayerMask whatIsWall;
    private bool hittingWall;

    private bool notAtEdge;
    public Transform edgeCheck;

    // Start is called before the first frame update
    void Start()
    {
        rb2d = GetComponent<Rigidbody2D>();
    }

    // Update is called once per frame
    void Update()
    {
        hittingWall = Physics2D.OverlapCircle(wallCheck.position, wallCheckRadius, whatIsWall);

        notAtEdge = Physics2D.OverlapCircle(edgeCheck.position, wallCheckRadius, whatIsWall);

        if (hittingWall || !notAtEdge)
            moveRight = !moveRight;
        

        if (moveRight)
        {
            transform.localRotation = Quaternion.Euler(0, 180, 0);
            rb2d.velocity = new Vector2(moveSpeed, rb2d.velocity.y);
        } else
        {
            transform.localRotation = Quaternion.Euler(0, 0, 0);
            rb2d.velocity = new Vector2(-moveSpeed, rb2d.velocity.y);
        }
        
    }
}
