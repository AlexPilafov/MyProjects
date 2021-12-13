using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BecomeChildOnCollision : MonoBehaviour
{
    // Start is called before the first frame update
    private void OnCollisionEnter2D(Collision2D col)
    {
        if (col.gameObject.name.Contains("Moving"))
            this.transform.parent = col.transform;
    }

    private void OnCollisionExit2D(Collision2D col)
    {
        if (col.gameObject.name.Contains("Moving"))
            this.transform.parent = null;
    }
}
