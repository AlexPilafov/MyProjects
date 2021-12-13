using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController2D : MonoBehaviour
{

    Animator animator;
    Rigidbody2D rb2d;
    SpriteRenderer spriteRenderer;

    [SerializeField] bool isGrounded;
    [SerializeField] bool doubleJumped;
    [SerializeField] bool jumpedOnce;


    [SerializeField]
    Transform groundCheck;
    [SerializeField]
    private float moveSpeed = 16.0f;
    [SerializeField]
    private float jumpHeight = 20;
    [SerializeField] private float doubleJumpForce = 20f;

    public Transform firePointRight;
    public Transform firePointLeft;

    public GameObject waterDrop;

    void Start()
    {
        animator = GetComponent<Animator>();
        rb2d = GetComponent<Rigidbody2D>();
        spriteRenderer = GetComponent<SpriteRenderer>();
    }

    private void Update()
    {
        //Checks
        if (Physics2D.Linecast(transform.position, groundCheck.position, 1 << LayerMask.NameToLayer("Ground")))
        {
            isGrounded = true;
            jumpedOnce = false;
            doubleJumped = false;
        }

        else
        {
            isGrounded = false;
            animator.Play("Jump");
        }

        //Movement
        if (Input.GetKey("d") || Input.GetKey("right"))
        {
            rb2d.velocity = new Vector2(moveSpeed, rb2d.velocity.y);

            if (isGrounded)
                animator.Play("Run");

            spriteRenderer.flipX = false;
        }

        else if (Input.GetKey("a") || Input.GetKey("left"))
        {
            rb2d.velocity = new Vector2(-moveSpeed, rb2d.velocity.y);

            if (isGrounded)
                animator.Play("Run");

            spriteRenderer.flipX = true;
        }

        else
        {
            if (isGrounded)
                animator.Play("Idle");

            rb2d.velocity = new Vector2(0, rb2d.velocity.y);
        }

        if (Input.GetKeyDown("space") && jumpedOnce && !doubleJumped || Input.GetKeyDown("w") && jumpedOnce && !doubleJumped || Input.GetKeyDown("up") && jumpedOnce && !doubleJumped)
        {
            rb2d.AddForce(transform.up * doubleJumpForce, ForceMode2D.Impulse);
            jumpedOnce = false;
            doubleJumped = true;
        }

        if (Input.GetKey("space") && isGrounded || Input.GetKey("w") && isGrounded || Input.GetKey("up") && isGrounded)
        {
            rb2d.velocity = new Vector2(rb2d.velocity.x, jumpHeight);
            jumpedOnce = true;
            doubleJumped = false;
        }

        if (Input.GetKeyDown("f"))
        {
            if (spriteRenderer.flipX == true)
            {
                Instantiate(waterDrop, firePointLeft.position, firePointLeft.rotation);
            }
            else
            {
                Instantiate(waterDrop, firePointRight.position, firePointRight.rotation);
            }
        }

        
    }

    private void FixedUpdate()
    {
        


    }

}
