using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MovingPlatform : MonoBehaviour
{
    public float moveSpeed = 3f;
    bool moveRight = true;
    public float fromX;
    public float toX;

    // Update is called once per frame
    void Update()
    {
        if (transform.position.x > fromX)
            moveRight = false;
        if (transform.position.x < toX)
            moveRight = true;

        if (moveRight)
            transform.position = new Vector2(transform.position.x + moveSpeed * Time.deltaTime, transform.position.y);
        else
            transform.position = new Vector2(transform.position.x - moveSpeed * Time.deltaTime, transform.position.y);
    }
}
