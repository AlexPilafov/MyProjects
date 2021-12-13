using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LevelManager : MonoBehaviour
{
    public GameObject checkpoint;
    private PlayerController2D player;
    private Rigidbody2D rb2d;
    public string gravestoneTag;
    public GameObject deathParticle;
    public GameObject graveStone;
    private SpriteRenderer sr;
    // Start is called before the first frame update
    void Start()
    {
        player = FindObjectOfType<PlayerController2D>();
        sr = player.GetComponent<SpriteRenderer>();
        rb2d = player.GetComponent<Rigidbody2D>();
    }

    // Update is called once per frame
    void Update()
    {

    }

    IEnumerator RespawnCoroutine()
    {
        Instantiate(graveStone, player.transform.position, player.transform.rotation);
        sr.enabled = false;
        rb2d.bodyType = RigidbodyType2D.Static;
        yield return new WaitForSeconds(1);
        player.transform.position = checkpoint.transform.position;
        ScoreManager.Reset();
        sr.enabled = true;
        rb2d.bodyType = RigidbodyType2D.Dynamic;
        ClearGravestones(gravestoneTag);
    }

    public void RespawnPlayer()
    {
        Instantiate(deathParticle, player.transform.position, player.transform.rotation);
        StartCoroutine(RespawnCoroutine());
        StopCoroutine(RespawnCoroutine());
    }

    public void ClearGravestones(string tag)
    {
        GameObject gameObject = GameObject.FindGameObjectWithTag(tag);
        GameObject.Destroy(gameObject);
    }
}
